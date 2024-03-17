XMLMerger is a Java program that merges data from two XML files containing license information based on specified keys (NIPR_Number, State_Code, License_Number, License_Issue_Date). The merged data is then written to a new XML file.

Functionality
Parsing XML Files:

The program parses two input XML files, License1.xml and License2.xml, containing license information.
It normalizes the XML structures for further processing.

Merging Data:
Data from both XML files is merged based on the specified keys.
Each license entry is uniquely identified by a composite key formed from NIPR_Number, State_Code, License_Number, and License_Issue_Date.

Creating Merged XML File:
The merged data is stored in a new XML file named MergedLicense.xml.
Each merged license entry is represented as an element under the root element <Merged_Licenses>.


Output:
The program generates a new XML file named MergedLicense.xml containing the merged license data which is already uploaded to the Git Repo.
Additionally I have added the same MergedLicense in a tabular format for easy readability with an additional Validity column at the end.

Execution
Compile the Java program XMLMerger.java.
Run the compiled class file (XMLMerger.class) to execute the merging process.
