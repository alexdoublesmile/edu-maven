package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.StudentOrderDao;
import edu.javacourse.studentorder.dao.StudentOrderDaoImpl;
import edu.javacourse.studentorder.domain.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {


    public static void main(String[] args) throws Exception {
        StudentOrderDao dao = new StudentOrderDaoImpl();

        List<StudentOrder> soList = dao.getStudentOrders();
        for (StudentOrder so : soList) {
            System.out.println(so.getStudentOrderId() );
        }
    }
}
