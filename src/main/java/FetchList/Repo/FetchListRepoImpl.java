package FetchList.Repo;

import FetchList.FetchList;
import FetchList.Model.FetchList1;

import java.util.List;

public interface FetchListRepoImpl {
    List<FetchList1> fetchList();
    boolean deleteData(int id);
    void insertMen(FetchList1 fetchList1);
}
