import java.util.List;
import java.util.Stack;

public class HomeworkM10FolderDriver {

	public static void main(String[] args) {
    	Folder folder1 = new Folder("Folder1");
    	Folder folder2 = new Folder("Folder2");
//    	Folder folder3 = new Folder("Folder3");
//    	Folder folder4 = new Folder("Folder4");
    	Folder folder1a = new Folder("Folder1a");
    	Folder folder1b = new Folder("Folder1b");
//    	Folder folder2a = new Folder("Folder2a");
//    	Folder folder2b = new Folder("Folder2b");
//    	Folder folder2c = new Folder("Folder2c");
//    	Folder folder4a = new Folder("Folder4a");
//    	Folder folder4b = new Folder("Folder4b");
    	folder1.addFolder(folder1a);
    	folder1.addFile(new File("File1-1"));
    	folder1.addFile(new File("File1-2"));
    	folder1.addFolder(folder1b);
//    	folder2.addFolder(folder2a);
//    	folder2.addFolder(folder2b);
//    	folder2.addFolder(folder2c);
//    	folder3.addFile(new File("File3-1"));
//    	folder4.addFolder(folder4a);
//    	folder4.addFile(new File("File4-1"));
//    	folder4.addFile(new File("File4-2"));
//    	folder4.addFolder(folder4b);

    	folder1a.addFile(new File("File1a-1"));
    	folder1a.addFile(new File("File1a-2"));
    	folder1b.addFile(new File("File1b-1"));
//    	folder2a.addFile(new File("File2a-1"));
//    	folder2a.addFile(new File("File2a-2"));
//    	folder2a.addFile(new File("File2a-3"));
//    	folder2c.addFile(new File("File2c-1"));
//    	folder4b.addFile(new File("File4b-1"));
//    	folder4b.addFile(new File("File4b-2"));
//    	folder4b.addFile(new File("File4b-3"));
    	
    	Folder topFolder = new Folder("TopFolder");
    	topFolder.addFolder(folder1);
    	topFolder.addFolder(folder2);
//    	topFolder.addFolder(folder3);
//    	topFolder.addFolder(folder4);

//    	printFolderContentsRecursive(topFolder);
    	printFolderContentsWithStack(topFolder);

	}
	
	public static void printFolderContentsRecursive(Folder topFolder) {
		printFolderContentsHelper(topFolder, 0);
	}
	private static void printFolderContentsHelper(Folder topFolder, int indentationIndex) {
		for(int i=0; i<indentationIndex; i++) {
			System.out.print("   ");
		}
		System.out.println(topFolder);
		if(!topFolder.getFileList().isEmpty()) {
			for(int i=0; i<indentationIndex+1; i++) {
				System.out.print("   ");
			}
			System.out.println(topFolder.getFileList()); // small part solving now- print the files in the current folder
		}
		
		List<Folder> subfolderList = topFolder.getFolderList();
		for(Folder subfolder : subfolderList) { 
			printFolderContentsHelper(subfolder, indentationIndex+1); // recursive call
		}
		
		// implicit base case- happens when a folder has no more subfolders- the recursion will end

	}

	public static void printFolderContentsWithStack(Folder topFolder) {

		int indentLevel = 0;

		Stack<Folder> folderStack = new Stack<Folder>();

		folderStack.push(topFolder);

		while (!folderStack.isEmpty()) {

			Folder currentFolder = folderStack.pop();
			List<Folder> folders = currentFolder.getFolderList();
			List<File> currentFiles = currentFolder.getFileList();

			indentLevel = folderIndentHelper(topFolder, currentFolder);
			printSpaces(indentLevel);
			System.out.println(currentFolder);

			if (!currentFiles.isEmpty()) {

				printSpaces(indentLevel);
				System.out.print("   ");
				System.out.println(currentFolder.getFileList());
			}
			
			if (!folders.isEmpty()) {

				for (int index = folders.size(); index > 0; index--) {

					folderStack.push(folders.get(index - 1));
				}
			}
		}
	}

	private static int folderIndentHelper(Folder top, Folder targetFolder) {

		// current issue, top isn't coming in correct every time.

		//TESTING
//		System.out.println("\n***** START HELPER ******\n target is: " + targetFolder + "\ntop is: " + top.getFolderList());


		int indentLevel = 0;

		if (!targetFolder.equals(top)) {

			Stack<Folder> subFolderStack = new Stack<Folder>();
			List<Folder> folders = top.getFolderList();
			List<Folder> subFolders;

			indentLevel = 1;

			// TESTING
//			System.out.println("\n***** BEFORE HELPER WHILE LOOP ******\ntop is: " + top.getFolderList());

//			System.out.println("############# in helper ###########");
//			System.out.println("\ttop is: " + top.getFolderList());

			while (!folders.isEmpty()) {

				// TESTING
//				System.out.println("\n***** TOP HELPER WHILE LOOP ******\n\ttop is: " + top.getFolderList());

				// iterate over all folders in a level
				for(int index = 0; index < folders.size(); index++) {

					if (targetFolder.equals(folders.get(index))) {


						// before this point top has been altered..
						//TESTING
//						System.out.println("\n***** RETURNING FROM HELPER ******\n\ttop is: " + top.getFolderList());


						return indentLevel;
					}

					else {

						subFolders = folders.get(index).getFolderList();

						for (Folder subFolder : subFolders) {

							subFolderStack.push(subFolder);
						}
					}

					// TESTING
//					System.out.println("\n***** END HELPER WHILE LOOP ******\n\ttop is: " + top.getFolderList());
				}

				folders.clear(); // reset folders for next level

				// TESTING
//				System.out.println("\n***** AFTER CLEAR ******\n\ttop is: " + top.getFolderList());

				while (!subFolderStack.isEmpty()) {

					folders.add(subFolderStack.pop());
				}

				indentLevel++;
			}
		}

		return indentLevel;
	}

	private static void printSpaces(int currentLevel) {

		for (int level = 0; level < currentLevel; level++) {

			System.out.print("   ");
		}
	}

} // close class
