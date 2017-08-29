package com.geecity.jucheng.datasupport;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.geecity.jucheng.datasupport.bean.Phone;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        openPhotoGrid();
    }

    private void openPhotoGrid() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        PhotoGridFragment fragment = PhotoGridFragment.newInstance();
        transaction.replace(R.id.ar_fl, fragment);
        transaction.commit();
    }

    @OnClick({R.id.btn_add, R.id.btn_del, R.id.btn_upt, R.id.btn_sel})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_add:// 新增
                add();
                break;
            case R.id.btn_del:// 删除
                del();
                break;
            case R.id.btn_upt:// 更新
                upt();
                break;
            case R.id.btn_sel:// 查询
                sel();
                break;
            default:
                break;
        }
    }

    private void add() {
        Phone phone1 = new Phone();
        phone1.setPhoneNumber("123456");
        phone1.save();

        Phone phone2 = new Phone();
        phone2.setPhoneNumber("456789");
        phone2.save();

        // 异步保存数据至数据库
//        phone1.saveAsync().listen(new SaveCallback() {
//            @Override
//            public void onFinish(boolean success) {
//
//            }
//        });
    }

    private void del() {
        DataSupport.delete(Phone.class, 1);
    }

    private void upt() {
        Phone updatePhone = new Phone();
        updatePhone.setPhoneNumber("147852");
        updatePhone.update(1);
    }

    private void sel() {
        // 异步查询所有电影数据
        DataSupport.findAllAsync(Phone.class).listen(new FindMultiCallback() {

            @Override
            public <T> void onFinish(List<T> t) {
                List<Phone> allPhones = (List<Phone>) t;
                if (allPhones == null || allPhones.size() == 0) return;
                for (Phone p : allPhones) {
                    if (p == null) continue;
                    System.out.println("-------------" + p.toString());
                }
            }
        });
    }
}
