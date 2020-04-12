package com.example.serviceImpl.layui;

import com.example.bean.VideoVo;
import com.example.bean.basic.LayuiPageQueryResult;
import com.example.bean.exampleBean.UserInfo;
import com.example.service.layui.LayuiVideoApi;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author by cld
 * @date 2020/4/4  11:08
 * @description:
 */
@Service
public class LayuiVideoApiImpl implements LayuiVideoApi {
    @Override
    public LayuiPageQueryResult<VideoVo> queryVideo(VideoVo vo) {

        String videoName = vo.getVideoName();

        LayuiVideoApiImpl ll = new LayuiVideoApiImpl();
        String str ="G:\\广场舞蹈";
        ArrayList<String> allFileName = ll.getAllFileName(str, videoName);
        LayuiPageQueryResult<VideoVo> pageQueryResult = new LayuiPageQueryResult<VideoVo>();

        List<VideoVo> list= new ArrayList<>();
        for(String name :allFileName){
            VideoVo bean = new VideoVo();
            bean.setVideoName(name);
            bean.setVideoFullPathName(str+"\\"+name);

            list.add(bean);
        }


        pageQueryResult.setData(list);
        //获取目录下所有文件名  或者 以什么结尾的文件
        return pageQueryResult;
    }

    public  ArrayList<String> getAllFileName(String path,String formate) {
        ArrayList<String> fileName = new ArrayList<String>();
        HashMap<String ,  ArrayList<String>> map = new HashMap<>();
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {

               String currFileName =  tempList[i].getName();
                File currFile =  tempList[i];

                if(currFileName.contains(formate)){
//                    System.out.println("文     件：" + currFile);
                    fileName.add(currFileName);
//                    filesFullPathName.add(path.concat("\\"+currFileName));
//                    System.out.println("文     件：" + path.concat("\\"+currFileName));
                }

                //fileNameList.add(tempList[i].toString());
//                fileNameList.add(tempList[i].getName());
            }
//            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
//                getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
//            }
        }
        return fileName;
    }

    public static void main(String[] args) {
        LayuiVideoApiImpl ll = new LayuiVideoApiImpl();
        String str ="G:\\广场舞蹈";
        ll.getAllFileName(str,".MP4");
    }
}
