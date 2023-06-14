public class StudentData {
    private String [][]data;

    public StudentData(){
        DataModel dataModel = new DataModel();
        data = dataModel.getData();
    }
    public String[][] getData(){
        return this.data;
    }
    public String[] getDataById(String id){

        for(int i = 0 ; i < data.length;i++){
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
            if(data[i][0] == null)break;
            if(id.compareTo(data[i][0]) != 0)
                updateData[k++] = this.data[i];

        }
        this.data = updateData;
    }
}
