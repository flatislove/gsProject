package com.flatislove.controller;

import com.flatislove.model.Employee;
import com.flatislove.model.repository.EmployeeRepository;
import com.flatislove.model.repository.PositionRepository;
import com.flatislove.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final
    EmployeeRepository employeeRepository;
    private final
    PositionRepository positionRepository;
    private final
    StatisticService statisticService;

    @Autowired
    public MainController(EmployeeRepository employeeRepository, PositionRepository positionRepository, StatisticService statisticService) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.statisticService = statisticService;
    }

    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("lastDayStatistic", statisticService.getLastDayStatistic());
        mv.addObject("allTimeStatistic", statisticService.getAllTimeStatistic());
        return mv;
    }

    @RequestMapping("/home")
    public ModelAndView doHomeMain() {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("lastDayStatistic", statisticService.getLastDayStatistic());
        mv.addObject("allTimeStatistic", statisticService.getAllTimeStatistic());
        return mv;
    }

    @RequestMapping("/employeeadd")
    public ModelAndView doAddEmployee() {
        ModelAndView mv = new ModelAndView("employeeadd");
        mv.addObject("positionList", positionRepository.findAll());
        return mv;
    }

    @RequestMapping("/employeeindex")
    public ModelAndView doEmployee() {
        ModelAndView mv = new ModelAndView("employeeindex");
        mv.addObject("lists", employeeRepository.findAll());
        mv.addObject("positionList", positionRepository.findAll());
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView doSave(@RequestParam("employeeId") String employeeId, @RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname, @RequestParam("email") String email,
                               @RequestParam("employeePosition") int employeePosition, @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView("redirect:/employeeindex");
        Employee employee;
        if (!employeeId.isEmpty()) {
            employee = employeeRepository.findOne(Integer.parseInt(employeeId));
        } else {
            employee = new Employee();
        }
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setEmployeePosition(employeePosition);
        employeeRepository.save(employee);
        return mv;
    }

    @RequestMapping(value = "/view/{employeeId}", method = RequestMethod.GET)
    public ModelAndView doView(@PathVariable("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("lists", employeeRepository.findOne(employeeId));
        mv.addObject("position",positionRepository.findOne(employeeRepository.
                findOne(employeeId).getEmployeePosition()));
        return mv;
    }

    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.GET)
    public ModelAndView doDelete(@PathVariable("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView("redirect:/");
        employeeRepository.delete(employeeId);
        return mv;
    }

    @RequestMapping(value = "/edit/{employeeId}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("employeeId") int employeeId) {
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("lists", employeeRepository.findOne(employeeId));
        return mv;
    }

    @RequestMapping(value = "/dbedit", method = RequestMethod.GET)
    public ModelAndView doEditForTovaroved() {
        return new ModelAndView("dbedit");
    }

    @RequestMapping(value = "/dbeditadmin", method = RequestMethod.GET)
    public ModelAndView doEditForAdmin() {
        return new ModelAndView("dbeditadmin");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("authentication");
        return model;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView doError() {
        return new ModelAndView("error");
    }
}
