// ��Ŀ���ӣ�https://www.nowcoder.com/questionTerminal/e2c8f6d0aa9443febc9412f8a2b23bf9

import java.util.*;

public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     *
     * @param n int����
     * @param m long������
     * @return long������һά����
     */
    public long[] FarmerNN (int n, long m) {
        // write code here
        long[] res = new long[n], tmp = new long[n + 2];
        long p = m - n;

        if(p <= 0) {
            tmp[1] ++;
            tmp[(int)m + 1] -- ;
        } else {
            tmp[1] ++ ;
            tmp[n + 1] -- ;
            if(n == 1) {
                tmp[1] += p;
            } else {
                long cnt = p / (n - 1), r = p % (n - 1);
                if(cnt % 2 == 0) {
                    tmp[n] -= cnt / 2;
                    tmp[n + 1] += cnt / 2;
                    tmp[1] -= cnt / 2;
                    tmp[2] += cnt / 2;

                    tmp[1] += cnt;
                    tmp[n + 1] -= cnt;

                    tmp[n] --;
                    tmp[n - (int)r] ++ ;
                } else {
                    cnt -- ;
                    tmp[n] -= cnt / 2;
                    tmp[n + 1] += cnt / 2;
                    tmp[1] -= cnt / 2;
                    tmp[2] += cnt / 2;

                    tmp[1] += cnt;
                    tmp[n + 1] -= cnt;

                    tmp[1] ++;
                    tmp[n] -- ;

                    tmp[2] ++ ;
                    tmp[(int)r + 2] -- ;
                }
            }
        }

        for(int i = 1; i <= n; i ++) tmp[i] += tmp[i - 1];
        for(int i = 0; i < n; i ++) res[i] = tmp[i + 1];
        return res;
    }
}
