package com.geecity.jucheng.datasupport;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;

import com.geecity.jucheng.datasupport.adpter.MainPhotoAdapter;
import com.geecity.jucheng.datasupport.base.GridPagingFragment;
import com.geecity.jucheng.datasupport.bean.Pictures;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PhotoGridFragment extends GridPagingFragment {

    private List<Pictures> arrayList = new ArrayList<>();

    public static PhotoGridFragment newInstance() {
        return new PhotoGridFragment();
    }

    @Override
    public void loadData(int pageIndex) {
        MainNet mainNet = new MainNet(mHandler, "http://www.jj20.com/bz/nxxz");
        mainNet.netStart();
    }

    @Override
    public List getDataList() {
        return arrayList;
    }

    @Override
    public RecyclerView.Adapter getAdapter(List list) {
        return new MainPhotoAdapter(list);
    }

    @Override
    public int defaultPartOnlineNumber() {
        return 2;
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            onLoaded(true);
            arrayList = (List<Pictures>) msg.obj;
            if (arrayList == null || arrayList.size() == 0) {
                System.out.println("---------------------");
                return;
            }
            for (Pictures p : arrayList) {
                if (p == null) continue;
                System.out.println(p.toString());
            }
        }
    };
}
