package com.company;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.util.*;

public class solutionTwitter {
    //时间戳
    static int timestamp = 0;
    //tweet类实现
   private static class Tweet{
        private int id;
        private int time;
        private Tweet next;
        public Tweet(int id,int time){
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User{
       private int id;
       public Set<Integer> followed;
       //用户发不的推文链表头结点
        public Tweet head;

        public User(int userId){
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            //关注自己
            follow(id);
        }
        public void follow(int userId){
            followed.add(userId);
        }
        public void unfollow(int userId){
            //不可以取消关注自己
            if(userId != this.id){
                followed.remove(userId);
            }
        }
        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId,timestamp);
            timestamp++;
            //将新建的推文插入链表头，越靠前的推文time值越大
            twt.next = head;
            head=twt;
        }

    }

    //将userID 和User 对象对应起来
    private HashMap<Integer,User> userMap = new HashMap<>();

   //user 发表一条tweet动态
    public void postTweet(int userId,int tweetId){
        //若userId不存在，则创建
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }
    //floower 关注followee
    public void follow(int followerId,int followeeId){
       //若follower不存在，则新建
       if(!userMap.containsKey(followerId)){
           userMap.put(followerId,new User(followerId));
       }
       //若followee不存在，则新建
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);

    }

    //follower 取消关注followee，如果ID不存在则什么都不做
    public void unfollow(int followerId ,int followeeId){
        if(userMap.containsKey(followerId)){
           userMap.get(followerId).unfollow(followeeId);
        }
    }

    //返回该user关注的人（包括自己)最近的动态ID,最多10条，而且这些动态必须
    //从新到旧的时间线顺序排列
    public List<Integer> getNewsFeed(int userId){
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }
        //关注列表的用户id
        Set<Integer> users = userMap.get(userId).followed;

        //自动通过time属性从大到小排序，容量为users的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(),(a,b) ->(b.time - a.time));

        //先将所有链表头解决插入优先级队列
        for(int id: users){
            Tweet twt = userMap.get(id).head;
            if(twt == null) continue;
            pq.add(twt);
        }
        while (! pq.isEmpty()){
            //最多返回10条就够了
            if(res.size() == 10)
                break;
            //弹出time值最大的（最近发表的)
            Tweet twt = pq.poll();
            res.add(twt.id);
            //将下一篇Tweet 插入进行排序
            if(twt.next != null){
                pq.add(twt.next);
            }
        }
        return res;
    }






}
