srcFile:=$(shell find ./src -type d -iname "*$(filename)*" | xargs -I {} find {} -iname "solution.*")

run:
	javac -cp src -d bin $(srcFile)
	java -cp bin $(shell cat $(srcFile) | head -n 1 | sed 's/;//' | sed 's/package//').Solution
