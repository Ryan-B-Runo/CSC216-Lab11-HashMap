import java.util.HashMap;

public class Driver {

    public static void main(String[] args) {

        System.out.println(canCreateNote("a", new String[]{"a"}));
        System.out.println(canCreateNote("a", new String[]{"ab"}));
        System.out.println(canCreateNote("a", new String[]{"a","b"}));
        System.out.println(canCreateNote("abc", new String[]{"a", "b", "c"}));
        System.out.println(canCreateNote("The bird is red!", new String[]{"I write a lot.", "To and fro.", "Here be deadly dragons!"}));
        System.out.println(canCreateNote("a", new String[]{"b"}));
        System.out.println(canCreateNote("a", new String[]{"bc"}));
        System.out.println(canCreateNote("a", new String[]{"b", "c"}));
        System.out.println(canCreateNote("abc", new String[]{"a", "b", "d"}));
        System.out.println(canCreateNote("The bird is red", new String[]{"I write a lot.", "To and fro."}));
        System.out.println(canCreateNote("The bird is red!", new String[]{"I write a lot.", "To and fro.", "Here be deadly dragons"}));

    }

    static boolean canCreateNote(String note, String[] articles){
        HashMap<Character,Integer> noteMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> articlesMap = new HashMap<Character,Integer>();

        for(String article : articles){
            for(char c : article.toCharArray()){
                if(articlesMap.containsKey(Character.toLowerCase(c))){
                    articlesMap.put(Character.toLowerCase(c),articlesMap.get(Character.toLowerCase(c))+1);
                }else{
                    articlesMap.put(Character.toLowerCase(c),1);
                }
            }
        }

        for(char c : note.toCharArray()){
            if(noteMap.containsKey(Character.toLowerCase(c))){
                noteMap.put(Character.toLowerCase(c),noteMap.get(Character.toLowerCase(c))+1);
            }else{
                noteMap.put(Character.toLowerCase(c),1);
            }
        }

        for(char c : noteMap.keySet()){
            if(c != ' '){
                if(articlesMap.containsKey(c)){
                    if(articlesMap.get(c) < noteMap.get(c)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}
