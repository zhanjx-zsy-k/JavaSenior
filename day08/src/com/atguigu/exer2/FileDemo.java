package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author k
 * @create 2021-04-28 0:36
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("G:\\io\\io1\\hello.txt");
        File file1 = new File(file.getParent(),"haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }
}
