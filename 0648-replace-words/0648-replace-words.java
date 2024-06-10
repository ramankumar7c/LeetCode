class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictSet = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");

        for(String word:words){
            String prefix="";
            for(int i=1;i<=word.length();i++){
                prefix = word.substring(0,i);
                if(dictSet.contains(prefix))
                break;
            }
            if(sb.length()>0)
            sb.append(" ");
            sb.append(dictSet.contains(prefix)?prefix:word);
        }
        return sb.toString();
    }
}