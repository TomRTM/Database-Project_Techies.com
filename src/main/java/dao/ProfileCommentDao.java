
package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import models.Diary;
import models.DiaryComment;
import models.Profile;
import models.Profilecomment;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProfileCommentDao {
    @Inject
    Provider<EntityManager> EntityManagerProvider;

    public List<Profilecomment> getCommentsByPosts(Profile profile) {

            EntityManager em = EntityManagerProvider.get();


            List<Profilecomment> profilecomments = new ArrayList<>();
            String strQuery = "SELECT x FROM ProfileComment x WHERE profile_id IN (";

                strQuery += "'" + profile.getId().toString() + "'";
            strQuery += ") ORDER BY timestamp DESC";

            Query q = em.createQuery(strQuery);
            profilecomments= (List<Profilecomment>) q.getResultList();

            return profilecomments;

    }
    public List<DiaryComment> getCommentsBydiary(Diary diary) {

        EntityManager em = EntityManagerProvider.get();


        List<DiaryComment> diarycomments = new ArrayList<>();
        String strQuery = "SELECT x FROM DiaryComment x WHERE diary_id IN (";

        strQuery += "'" + diary.getId().toString() + "'";

        strQuery += ") ORDER BY timestamp DESC";

        Query q = em.createQuery(strQuery);
        diarycomments = (List<DiaryComment>) q.getResultList();


        return diarycomments;


    }

}
