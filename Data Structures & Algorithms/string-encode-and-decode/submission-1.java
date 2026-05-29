class Solution {

    private String delimiter = "ð";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for(String s: strs) {
            encodedString.append(s).append(delimiter);
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodedString = s.split(delimiter, -1);
        return new ArrayList<>(Arrays.asList(decodedString).subList(0, decodedString.length - 1));
    }
}
