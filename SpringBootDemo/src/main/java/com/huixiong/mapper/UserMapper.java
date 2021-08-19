package com.huixiong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huixiong.model.User;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author timothy
 * @data 2021年08月03日 11:40 上午
 */
public interface UserMapper extends BaseMapper<User> {
    public static void main(String[] args)
    {

        // creating a list where first argument
        // represents the number of copies and
        // the second argument represents the
        // element to be copied for 'number' times
        // This will create 4 copies of the objects.
        List<String> list = Collections.nCopies(4, "GeeksforGeeks");

        // Displaying the list returned
        System.out.println("The list returned is :");
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println("\n");

        List list1 = Collections.nCopies(3, "GeeksQuiz");

        // Displaying the list returned
        System.out.println("The list returned is :");
        Iterator itr1 = list1.iterator();
        while (itr1.hasNext()) {
            System.out.print(itr1.next() + " ");
        }
        System.out.print("\n");
    }
}
