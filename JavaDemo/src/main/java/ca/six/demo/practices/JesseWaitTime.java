package ca.six.demo.practices;

/*
每次每人只能买一张. 但有些人要买多张.  你要想买多张, 你买好一张后, 就再到队尾再排队
input是(int[] tickets, int position)
output是要几人次才轮到第position这人买完

比如说: 有三人A/B/C排队, 每人想买的票是 tickets[] 为{2, 1, 3}, p = 2(即第三个人)
那就是A买完一张后, 队伍成了BCA
B买完一张, 他就好了, 不用再排除, 队伍就是CA
C完一张后, 队伍成了AC
...
所以最终就是 1 1 3, 1 2, 1, 一共就是要6人次才轮到

 */
public class JesseWaitTime {
    static long waitingTime(int[] tickets, int p) {
        long result = 0;
        int index = 0;
        int myTickets = tickets[p];

        for (int othersTicket : tickets) {
            if (index <= p) {
                if ((othersTicket - myTickets) <= 0) {
                    result += othersTicket;
                } else {
                    result += myTickets;
                }
            } else {
                if (othersTicket >= myTickets) {
                    result += (myTickets - 1);
                } else {
                    result += othersTicket;
                }
            }

            index++;
        }

        return result;

    }
}

// 要有多个input来验证是否正确
// 出过错的例子有: waitingTime({1, 1, 1, 1}, 0), 应该输出1, 但我在else {if (othersTicket > myTickets)时写错了, 应该是>=
