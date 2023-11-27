package midterm.bai2;

public class Dictionary {
    private DictList<String> vietnameseList;
    private DictList<String> englishList;

    public Dictionary() {
        vietnameseList = new DictList<>();
        englishList = new DictList<>();
    }

    public void loadDictionary(String[] vi, String[] en) {
        for (String wordVi : vi) {
            vietnameseList.add(wordVi);
        }

        for (String wordEn : en) {
            englishList.add(wordEn);
        }
    }

    public DictList<String> translate(DictList<String> vi) {
        DictList<String> translatedList = new DictList<>();
        for (int i = 0; i < vi.size(); i++) {
            String wordVi = vi.get(i);
            // Tìm từ tương ứng trong danh sách tiếng Việt
            int index = vietnameseList.indexOf(wordVi);
            
            // Nếu tìm thấy, thêm từ tương ứng từ danh sách tiếng Anh vào danh sách dịch
            if (index != -1) {
                String wordEn = englishList.get(index);
                translatedList.add(wordEn);
            } else {
                // Nếu không tìm thấy, có thể xử lý tùy ý, ví dụ: thêm từ rỗng vào danh sách dịch
                translatedList.add("");
            }
        }
        return translatedList;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        // Ví dụ về cách sử dụng
        String[] vi = {"Xin chào", "Xin lỗi", "Tạm biệt"};
        String[] en = {"Hello", "Sorry", "Goodbye"};

        dictionary.loadDictionary(vi, en);

        DictList<String> viList = new DictList<>();
        viList.add("Xin chào");
        viList.add("Tạm biệt");

        DictList<String> enList = dictionary.translate(viList);

        // In ra kết quả dịch
        System.out.println("Danh sách tiếng Anh tương ứng:");
        for (int i = 0; i < enList.size(); i++) {
            System.out.println(viList.get(i) + " - " + enList.get(i));
        }
    }
}