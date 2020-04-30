package com.kingluffy.playstation.no1095;

/**
 *
 * No1095
 *
 * 在一个转角图形中，三个数连续上升，最后两个临近，说明连续上升
 *
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no1095
 * @ClassName: FindInMountainArray
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/4/29 8:46 PM
 * @Version: 1.0
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int res=0;

        int peerIdx = findPeer2(mountainArr);

        int peerValue = mountainArr.get(peerIdx);
        if(target>peerValue){
            return -1;
        }
        if(target==peerValue){
            return peerIdx;
        }
        res = findTar2(mountainArr,target,0,peerIdx-1,false);
        if(res!=-1){
            return res;
        }
        res = findTar2(mountainArr,target,peerIdx+1,mountainArr.length()-1,true);



        return res;
    }

    private static int findPeer2(MountainArray mountainArr){

        int head = 0;
        int tail = mountainArr.length()-1;
        int mid ;
        int midp1;
        while (true){
            mid = (head +tail) /2;
            midp1 = mid+1;

            if(mid==head+1 && midp1==tail){
                return mid;
            }

            if(mountainArr.get(head)<mountainArr.get(mid) && mountainArr.get(mid)<mountainArr.get(midp1)){
                //head 2 mid is in order
                head = mid;

            }else{
                tail = midp1;
            }
        }

    }


    private static int findTar2(MountainArray mountainArr,int tar,int head,int tail,boolean reverse){

        int mid;
        int midValue;

        while(true){
            mid = (head + tail)/2;


            if(mid==head){
                if(mountainArr.get(head)==tar) return head;
                if(mountainArr.get(tail)==tar) return tail;
                return -1;
            }

            midValue = mountainArr.get(mid);

            if(midValue==tar){
                return mid;
            }

            if(midValue>tar){
                if(reverse){
                    head = mid;
                }else {
                    tail = mid;
                }
            }else {
                if(reverse){
                    tail = mid;
                }else {
                    head = mid;
                }
            }

        }

    }



    private static int findPeer(int[] src){

        int head = 0;
        int tail = src.length-1;
        int mid ;
        int midp1;
        while (true){
            mid = (head +tail) /2;
            midp1 = mid+1;

            if(mid==head+1 && midp1==tail){
                return mid;
            }

            if(src[head]<src[mid] && src[mid]<src[midp1]){
                //head 2 mid is in order
                head = mid;

            }else{
                tail = midp1;
            }
        }

    }

    private static int findTar(int[] src,int tar){

        int head = 0;
        int tail = src.length-1;
        return findTar(src,tar,head,tail,false);

    }

    private static int findTar(int[] src,int tar,int head,int tail,boolean reverse){

        int mid;

        while(true){
            mid = (head + tail)/2;


            if(mid==head){
                if(src[head]==tar) return head;
                if(src[tail]==tar) return tail;
                return -1;
            }

            if(src[mid]==tar){
                return mid;
            }

            if(src[mid]>tar){
                if(reverse){
                    head = mid;
                }else {
                    tail = mid;
                }
            }else {
                if(reverse){
                    tail = mid;
                }else {
                    head = mid;
                }
            }


        }

    }



    public static int mountain(int[] src, int target){
        int res;

        int len = src.length-1;

        int peerIdx = findPeer(src);

        int peerValue = src[peerIdx];
        if(target>peerValue){
            return -1;
        }
        if(target==peerValue){
            return peerIdx;
        }
        res = findTar(src,target,0,peerIdx-1,false);
        if(res!=-1){
            return res;
        }
        return findTar(src,target,peerIdx+1,len,true);
    }

    public static void main(String[] args) {
        int[] src = new int[]{3,5,3,2,0};
        int target = 0;

        int res = mountain(src,target);

        System.out.println(res);
    }
}
