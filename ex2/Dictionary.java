package ex2;


@SuppressWarnings("unchecked")
public class Dictionary {
   
	private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh
	
	public Dictionary() {
        viList = new DictList<>();
        enList = new DictList<>();
    }

	//Phương thức loadDictionary(String[] vi, String[] en), 
	//phương thức này thực hiện nạp từ điển, lưu các phần tử trong mảng vi vào danh sách chứa các từ tiếng Việt,
	//và các phần từ trong mảng en vào danh sách chứa các từ tiếng Anh.
	public void loadDictionary(String[] vi, String[] en) {
        for (String wordVi : vi) {
            viList.add(wordVi);
        }

        for (String wordEn : en) {
            enList.add(wordEn);
        }
    }
	
	public DictList<String> translate(DictList<String> vi)
	{
		DictList<String> translatedList = new DictList<>();
        for (int i = 0; i < vi.size(); i++) {
            String wordVi = vi.get(i);
            int index = viList.indexOf(wordVi);
            System.out.println(index);
            
            if (index != -1) {
                String wordEn = enList.get(index);
                translatedList.add(wordEn);
            } else {
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

