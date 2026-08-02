#!/bin/bash
# OIW Groovy Runner wrapper
# Usage: echo '{"scriptPath":"...","message":{...},"timeoutMs":30000}' | oiw-groovy-runner.sh
DIR="$(cd "$(dirname "$0")" && pwd)"
java -cp "$DIR/build:$DIR/lib/*" io.oiw.groovy.GroovyRunner
