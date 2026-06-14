class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        char[] arr = str.toCharArray();
        while(i < arr.length){
            StringBuilder sb = new StringBuilder();
            int j = i;
            while(arr[j] != '#'){
                
                sb.append(arr[j]);
                j++;
            }
            int len = Integer.parseInt(sb.toString());
            i = j + 1;
            list.add(str.substring(i, i + len));
            i = i +len;
        }
    return list;
    }
}
