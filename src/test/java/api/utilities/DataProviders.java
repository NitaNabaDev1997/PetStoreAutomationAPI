package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name="Data")
    public static String[][] getAllData() throws IOException {
        String path= System.getProperty("user.dir")+"/testData/Userdata.xlsx";
        XLUtility xlUtility= new XLUtility(path);

        int rowcount= xlUtility.getRowCount("Sheet1");
        int colcount= xlUtility.getCellCount("Sheet1",1);

        String data[][]= new String[rowcount][colcount];
        for(int i=1;i<=rowcount;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                data[i-1][j]=xlUtility.getCellData("Sheet1",i,j);
            }
        }

        return  data;
    }


    @DataProvider(name="getUserName")
    public static String[] getUserNames() throws IOException {
        String path=System.getProperty("user.dir")+"/testData/Userdata.xlsx";
        XLUtility xlUtility= new XLUtility(path);

        int rowcount= xlUtility.getRowCount("Sheet1");

        String data[]= new String[rowcount];
        for(int i=1;i<=rowcount;i++)
        {
        data[i-1]=xlUtility.getCellData("Sheet1",i,1);
        }
        return data;
    }
}
