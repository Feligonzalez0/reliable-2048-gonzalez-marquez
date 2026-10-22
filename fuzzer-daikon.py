"""
Fuzzer for the Reliable 2048 CLI.

Structure follows the Fuzzing Book (Zeller et al.):
  https://www.fuzzingbook.org/

A Fuzzer generates inputs; a Runner executes the program under test and
classifies the outcome.  The two are kept separate so that different fuzzers
can be combined with the same runner, and vice-versa.
"""

# Este programa cada vez que runner.run(inp) se ejecuta, Chicory instrumenta el programa y guarda una traza para esa ejecución.

import subprocess
import random
from typing import Tuple
import os
from pathlib import Path
# ---------------------------------------------------------------------------
# Outcome constants  (mirrors the Fuzzing Book convention)
# ---------------------------------------------------------------------------

PASS = "PASS"       # program exited normally, no errors reported
FAIL = "FAIL"       # program signalled a bug (non-zero exit, assertion error)
UNRESOLVED = "UNRESOLVED"  # e.g. timeout or unexpected error in the runner

# ---------------------------------------------------------------------------
# Valid input alphabet
# ---------------------------------------------------------------------------

KEYS = ['a', 's', 'w', 'd']   # left, down, up, right
QUIT = 'q'                     # graceful exit

# ---------------------------------------------------------------------------
# Runner
# ---------------------------------------------------------------------------

class Runner:
    """Runs the program under test and returns (output, outcome)."""

    def run(self, inp: str) -> Tuple[subprocess.CompletedProcess, str]:
        raise NotImplementedError



class CLIRunner(Runner):
    """Ejecuta el CLI instrumentado con Chicory y guarda una traza por partida."""

    TIMEOUT = 10

    def __init__(self, trace_dir="daikon-traces/fuzzer"):
        self.trace_dir = Path(trace_dir)
        self.trace_dir.mkdir(parents=True, exist_ok=True)
        self.trial = 0

        # Construye el classpath con las dependencias de Maven.
        dependencies = subprocess.check_output(
            [
                "cmd.exe", "/c",
                "mvn", "dependency:build-classpath",
                "-q", "-DforceStdout"
            ],
            text=True
        ).strip()

        self.classpath = os.pathsep.join([
            "lib/daikon.jar",
            "target/classes",
            dependencies
        ])

    def run(self, inp: str) -> Tuple[subprocess.CompletedProcess, str]:
        self.trial += 1
        trace_name = f"fuzzer_{self.trial:03d}.dtrace.gz"

        command = [
            "java",
            "-cp", self.classpath,
            "daikon.Chicory",
            "--ppt-select-pattern=ar.edu.unrc.game2048.(Board|Cell)",
            f"--output-dir={self.trace_dir}",
            f"--dtrace-file={trace_name}",
            "ar.edu.unrc.game2048.MainCLI"
        ]

        try:
            result = subprocess.run(
                command,
                input=inp,
                capture_output=True,
                text=True,
                timeout=self.TIMEOUT
            )
        except subprocess.TimeoutExpired:
            return None, UNRESOLVED

        if result.returncode != 0 or result.stderr:
            return result, FAIL

        return result, PASS


# ---------------------------------------------------------------------------
# Fuzzer base class
# ---------------------------------------------------------------------------

class Fuzzer:
    """Base class: subclasses implement fuzz() to produce one input string."""

    def fuzz(self) -> str:
        """Return a single fuzzed input string."""
        raise NotImplementedError

    def run(self, runner: Runner) -> Tuple[subprocess.CompletedProcess, str]:
        """Fuzz once and run the result through *runner*."""
        return runner.run(self.fuzz())

    def runs(self, runner: Runner, trials: int = 10):
        """Fuzz *trials* times and return a list of (result, outcome) pairs."""
        return [self.run(runner) for _ in range(trials)]


# ---------------------------------------------------------------------------
# RandomFuzzer
# ---------------------------------------------------------------------------

class RandomFuzzer(Fuzzer):
    """
    Generates a random sequence of game moves followed by a quit command.

    Parameters
    ----------
    min_length : int
        Minimum number of move keys in the sequence.
    max_length : int
        Maximum number of move keys in the sequence.
    """

    def __init__(self, min_length: int = 10, max_length: int = 50):
        self.min_length = min_length
        self.max_length = max_length

    def fuzz(self) -> str:
        length = random.randint(self.min_length, self.max_length)
        result = ""
        
        for i in range (0, length, 1):
            result += random.choice(KEYS) + "\n"
        
        result += "q\n"

        return result
            

# ---------------------------------------------------------------------------
# Main: run the fuzzer and report results
# ---------------------------------------------------------------------------

def main():
    runner = CLIRunner()
    fuzzer = RandomFuzzer(min_length=500, max_length=700)

    trials = 100
    outcomes = {PASS: 0, FAIL: 0, UNRESOLVED: 0}

    print(f"Running {trials} fuzzing trials...\n")

    for i in range(trials):
        inp = fuzzer.fuzz()
        result, outcome = runner.run(inp)

        outcomes[outcome] += 1

        print(f"--- Trial {i + 1:>3} | {outcome} ---")
        print(f"Input : {inp.replace(chr(10), ' ').strip()}")

        if result is not None:
            print(f"Exit  : {result.returncode}")
            if result.stdout:
                print(f"Output: {result.stdout.strip()}")
            if result.stderr:
                print(f"Stderr: {result.stderr.strip()}")

        print()

    print("=" * 50)
    print("Summary:")
    for outcome, count in outcomes.items():
        print(f"  {outcome:<12}: {count}/{trials}")


if __name__ == "__main__":
    main()
