fName:=$(shell ls -R | grep -i "$(name).*.java")
fileName:=$(shell echo ${fName} | sed "s/.java//")
srcFile:=$(shell echo ${fName} | xargs -I {} find . -iname {})

sfName:=$(shell ls -R | grep -i "src.*$(name).*" | sed "s/:/\/Solution.java/")

run:
	javac -cp . -d ./bin $(srcFile)
	java -cp ./bin $(shell cat $(srcFile) | head -n 1 | sed "s/package//" | sed "s/;//").$(fileName)

run_s:
	javac -cp . -d ./bin $(sfName)
	java -cp ./bin $(shell cat $(sfName) | head -n 1 | sed "s/package//" | sed "s/;//").Solution

run_bulk:
	powershell "Remove-Item *.class"
	javac ./BulkFormat.java
	java BulkFormat

reset:
	git reset --hard
	git clean -fxd
