package com.fyytest.recode_school.controller;

import com.fyytest.recode_school.entity.Elective;
import com.fyytest.recode_school.entity.Grade;
import com.fyytest.recode_school.entity.Student;
import com.fyytest.recode_school.service.ElectiveService;
import com.fyytest.recode_school.service.GradeService;
import com.fyytest.recode_school.service.StudentService;
import com.fyytest.recode_school.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fyytest.recode_school.util.PageUtil.PAGESIZE;

@Controller
public class StudentController {
    //    查询所有学生数据方法
    @Autowired
    StudentService studentService;
    @Autowired
    GradeService gradeService;
    @Autowired
    ElectiveService electiveService;

    /**
     * 查询学生信息
     *
     * @param sname
     * @param gid
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(String sname, Long gid, @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, Model model) {

//        查询总条数
        Integer studentCount = studentService.getStudentCount(sname, gid);
//        总条数/页面大小 =总的页数
        Integer size = (int) studentCount / PageUtil.PAGESIZE;
        if (studentCount % PageUtil.PAGESIZE != 0) {
            size++;
        }
        if (pageIndex > size) {
            pageIndex = 1;
        }
//        size要是不传给前段 就无法调用显示
        model.addAttribute("size", size);

        List<Student> students = studentService.getStudents(sname, gid, pageIndex);
//        添加到模块当中
        model.addAttribute("students", students);
        List<Grade> grades = gradeService.getGrades();
        model.addAttribute("grades", grades);

//        查询科目列表
        List<Elective> electives = electiveService.getElectives();
        model.addAttribute("electives", electives);


//        回显 当前页
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("sname", sname);
        model.addAttribute("gid", gid);

        return "index";
    }

    //ajax回传
    @ResponseBody
    @RequestMapping("/updateStudent")
    public Map updateStudent(@RequestBody Student student) {
        boolean result = studentService.updateStudent(student);
        HashMap hashMap = new HashMap();
        hashMap.put("student", student);
        hashMap.put("result", result);
        return hashMap;
    }

    //    录入学生跳转

    /**
     * 打开添加页面
     *
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String add(Model model) {
//        班级和课程的信息
        List<Grade> grades = gradeService.getGrades();
        List<Elective> electives = electiveService.getElectives();
        model.addAttribute("grades", grades);
        model.addAttribute("electives", electives);
        return "add";
    }

    //    执行添加
    @PostMapping("/doAdd")
    public String doAdd(Student student) {
        Long id = getUniqueNum();
        student.setId(id);
        Integer add = studentService.add(student);
        System.out.println(add);
        if (add > 0) {
            return "redirect:/index";
        } else {
            return "redirect:/add";
        }
    }


    //    删除
    @ResponseBody
    @GetMapping("/delete/{id}")
    public Map delete(@PathVariable(value = "id") Long id) {
        HashMap hashMap = new HashMap<>();
        Integer delete = studentService.delete(id);
        System.out.println(delete);
        hashMap.put("result", delete);
        return hashMap;
    }

    //    时间戳
    public static Long getUniqueNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        String id = sdf.format(System.currentTimeMillis());
        return Long.parseLong(id);
    }
}
