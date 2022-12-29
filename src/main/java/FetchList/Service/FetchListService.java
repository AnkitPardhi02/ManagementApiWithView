package FetchList.Service;

//import FetchList.FetchList;
import FetchList.Model.FetchList1;
import FetchList.Repo.FetchListRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FetchListService implements FetchListServiceImpl{

    @Autowired
    private FetchListRepoImpl fetchListRepo;
    @Override
    public List<FetchList1> fetchList() {
        return fetchListRepo.fetchList();
    }

    @Override
    public boolean deleteData(int id) {
        return fetchListRepo.deleteData(id);
    }

    @Override
    public void insertMen(FetchList1 fetchList1) {
        fetchListRepo.insertMen(fetchList1);

    }
}
