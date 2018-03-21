package org.osgi.project.impl;

import org.osgi.project.Student;
import org.osgi.project.service.ConfigService;
import org.osgi.project.service.StudentApplication;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component(service = StudentApplication.class, immediate = true)
@Designate(ocd = ConfigService.class)
public class StudentApplicationImpl implements StudentApplication {

    ConfigService configuration;

    private int limit;
    private int reqmks;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Activate
    public void activate(ConfigService config) {
        configuration = config;
        limit = configuration.getNos();
        reqmks = configuration.getReqMarks();
        logger.info("number of students : " + limit + " required marks: " + reqmks);
    }

    @Override
    public boolean isClassLimitReached(List<Student> a) {


        if (a.size() >= limit)
            return true;
        return false;
    }

    @Override
    public int getPassingMarks() {

        return reqmks;
    }
}
