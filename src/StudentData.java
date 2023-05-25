public class StudentData {
    private String [][]data={
            {"221-15-5037","Shakil Ahmed","CSE","Regular","shakil@gmail.com"},
            {"221-15-5578","Riyad Ahmed","CSE","Regular","riyad@gmail.com"},
            {"221-15-4995","Sanaullah sani","CSE","Regular","sani@gmail.com"},
            {"221-15-4996","Zahid patwary","CSE","Regular","zahid@gmail.com"},
            {"221-15-4724","Sakib Al Hasan","CSE","Regular","sakib@gmail.com"},
            {"221-15-1234","Evaan Rahman","CSE","Regular","evaan@gmail.com"},
            {"221-15-5077","Sumaiya binte Mizan","CSE","Regular","sumaiya@gmail.com"},
            {"221-15-2314","Meheraj buiyan","CSE","Regular","meheraj@gmail.com"},
            {"221-15-5845","Ariful Hasan","CSE","Regular","ariful@gmail.com"},
            {"221-15-5662","Emran Haque","CSE","Regular","emran@gmail.com"},
            {"221-15-4668","Sanjida Nishe","NFE","Regular","sanjida@gmail.com"},
            {"221-15-5563","Farjana Bristy","FTNS","Regular","bristy@gmail.com"}

    };
    public StudentData(){}
    public String[][] getData(){
        return this.data;
    }
    public String[] getDataById(String id){

        for (int i = 0 ; i < data.length;i++){
            if(id.compareTo(data[i][0]) == 0)
                return data[i];
        }
        return null;
    }
    public int updateById(String id,String name,String Dept,String type,String email){

        String []upDate = {id,name,Dept,type,email};
        for (int i = 0 ; i < data.length;i++){
            if(id.compareTo(data[i][0]) == 0){
                data[i] = upDate;
                return 1;
            }
        }
        return  0;
    }

    public void deleteById(String id){
        String[][] updateData = new String[15][5];
        int k = 0;
        for (int i = 0 ; i < data.length;i++){
            if(id.compareTo(data[i][0]) != 0)
                updateData[k++] = this.data[i];

        }
        this.data = updateData;
    }
}
