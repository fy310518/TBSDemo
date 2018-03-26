package com.example.tbsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.File;


/**
 * 使用tbs 不同格式文件浏览 activity
 * Created by fangs on 2017/12/4.
 */
public class FileBrowsingActivity extends AppCompatActivity{

    SuperFileLayout mSuperFileView;
    //需要查看的 文档所在目录
    String filePath = "/storage/emulated/0/大王/阿里巴巴Android开发手册.pdf";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_browsing);

        mSuperFileView = findViewById(R.id.mSuperFileView);

        init();
    }

    protected void init() {
        mSuperFileView.setOnGetFilePathListener(new SuperFileLayout.OnGetFilePathListener() {
            @Override
            public void onGetFilePath(SuperFileLayout mSuperFileView) {
                getFilePathAndShowFile(mSuperFileView);
            }
        });

        mSuperFileView.show();
    }

    private void getFilePathAndShowFile(SuperFileLayout superFileView) {
        if (filePath.contains("http")) {//网络地址要先下载

//            downLoadFromNet(getFilePath(),mSuperFileView2);
        } else {
            superFileView.displayFile(new File(filePath));
        }
    }

    @Override
    public void onDestroy() {
        if (null != mSuperFileView) {
            mSuperFileView.onStopDisplay();
        }
        super.onDestroy();
    }



}
