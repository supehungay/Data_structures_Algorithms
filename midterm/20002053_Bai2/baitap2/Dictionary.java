
public class Dictionary {
   
	private DictList<String> viList = null; // Danh sách lưu các từ tiếng Việt
    private DictList<String> enList = null; // Danh sách lưu các từ tiếng Anh
	
	//Phương thức loadDictionary(String[] vi, String[] en), 
	//phương thức này thực hiện nạp từ điển, lưu các phần tử trong mảng vi vào danh sách chứa các từ tiếng Việt,
	//và các phần từ trong mảng en vào danh sách chứa các từ tiếng Anh.
	public void loadDictionary(String[] vi, String[] en)
	{
        DictList<String> viTemp = new DictList<>();
        DictList<String> enTemp = new DictList<>();
        for (int i = 0; i < vi.length; i++) {
            viTemp.add(vi[i]);
            enTemp.add(en[i]);
        }

        viList = viTemp;
        enList = enTemp;
	}
	
	//Phương thức translate(DictList vi),
	//phương thức này trả lại 1 danh sách các từ tiếng Anh tương ứng với các từ tiếng Việt trong danh sách vi.
	public DictList<String> translate(DictList<String> vi)
	{
        DictList<String> trans = new DictList<>();
		for (int i = 0; i < vi.size(); i++) {
            int idx = 0;
            for (String s : viList) {
                System.out.println("2. " + s);
                if (s.equals(vi.get(i))) {
                    trans.add(enList.get(idx));
                }
                idx++;
            }
        }

        return trans;
	}

    public static void main(String[] args) {
        String [] en = {"one","two","three","four","five"};
        String [] vi = {"mot","hai","ba","bon","nam"};
        Dictionary dc = new Dictionary () ;
        dc.loadDictionary ( vi , en ) ;
        DictList < String > vil = new DictList < String >() ;
        vil.add ("mot") ;
        vil.add ("hai") ;
        vil.add ("ba") ;
        DictList < String > trans = dc.translate ( vil ) ;
        for ( int i = 0 ; i < trans.size () ; i ++)
            System.out.println ( trans.get ( i ) ) ;

    }

}

