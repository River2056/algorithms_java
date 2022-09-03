run_bulk:
	powershell "Remove-Item *.class"
	javac ./BulkFormat.java
	java BulkFormat
