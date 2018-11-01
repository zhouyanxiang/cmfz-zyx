package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ArticalDao;
import com.baizhi.dao.BannerDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Artical;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/10/30.
 */
@Service
@Transactional
public class RestfulServiceImpl implements RestfulService {


    @Autowired
    BannerDao bannerDao;
    @Autowired
    AlbumDao albumDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ArticalDao articalDao;




    @Override
    public Map queryFisrstPage(int uid, String type) {

        Map map = null;
        User user = userDao.selectOne(uid);
        String wen1 = "wen";
        String all1 = "all";

        if (user != null) {

            if (type.equals(all1)) {
                map = new HashMap();
                List<Banner> bannerList = bannerDao.queryAllBanner();
                List<Album> albumAndChapterList = albumDao.selectAllAlbumAndChapter();

                map.put("header", bannerList);
                map.put("album", albumAndChapterList);


            } else if (type.equals(wen1)) {
                List<Album> albumAndChapter = albumDao.selectAllAlbumAndChapter();
                System.out.println("albumAndChapter+++"+albumAndChapter);
                map.put("album", albumAndChapter);

            } else {

                map.put("is", "请携带正确的参数访问");
            }

              return map;
        }else {
            map.put("is","用户请登陆");
            return map;

        }

    }

    @Override
    public Artical selectArtical(int id,String user_id) {

        int uid=Integer.parseInt(user_id);
        System.out.println(user_id);
        User user = userDao.selectOne(uid);
        Artical artical = null;
        if(user !=null){
            artical = articalDao.selectArtical(id);

            User user1 = userDao.selectOne(uid);

            System.out.println("use不为null");


        }

        return artical;
    }
}
