package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if ( str==null || str.trim().isEmpty() ){
            throw new IllegalArgumentException("Empty string!");
        }

        String strNew=str.trim();
        return strNew.charAt(strNew.length() - 1);
    }

    public String findFileExtension(String str){
        if (str==null || str.trim().isEmpty() || str.startsWith(".")){
            throw new IllegalArgumentException("Invalid file name!");
        }

        String strTrim=str.trim();
        int index=str.lastIndexOf('.');

        return strTrim.substring(index);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (ext==null || fileName==null || ext.trim().isEmpty() || fileName.trim().isEmpty() || fileName.startsWith(".")){
            throw new IllegalArgumentException("Invalid argument!");
        }
        String extTrim = ext.trim();
        String fileNameTrim = fileName.trim();

        int index = fileNameTrim.lastIndexOf('.');

        return fileNameTrim.endsWith(extTrim);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (searchedFileName==null || actualFileName==null || searchedFileName.trim().isEmpty() || actualFileName.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid argument!");
        }
        boolean isSame=false;
        if (searchedFileName.trim().toLowerCase().equals(actualFileName.trim().toLowerCase())){
            isSame=true;
        }
        return isSame;
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (fileName.trim().isEmpty()){
            throw new IllegalArgumentException("Empty string!");
        }
        if (fileName==null || fileName.startsWith(".")){
            throw new IllegalArgumentException("Invalid argument!");
        }

        return  fileName.substring(0,fileName.lastIndexOf('.')) + fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
    }

    public String replaceStringPart(String fileName, String present, String target) {
        String srt="";
        if (fileName==null || fileName.trim().isEmpty()){
            throw new IllegalArgumentException("Empty string!");
        }
        if (!fileName.contains(present)){
            srt+=fileName;
        } else {
            srt += fileName.replace(present,target);
        }
        return srt;
    }
}
