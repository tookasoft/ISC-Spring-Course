package org.example.service;

import org.example.dao.OrganizationDao;
import org.example.domain.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);

    @Autowired
    private OrganizationDao organizationDao;

    public void createSeedData() {

        Organization organization1 = new Organization("Microsoft",
                1988, 12112, 70000,
                "Slogan Microsoft");

        Organization organization2 = new Organization("IBM",
                1943, 23453, 120000,
                "Slogan IBM");

        Organization organization3 = new Organization("Google",
                1996, 57575, 4567, "Don't be evil");

        var organizations = List.of(organization1, organization2, organization3);

        organizations.stream().forEach(org -> organizationDao.create(org));

    }

    public void printOrganization(Organization org) {

        System.out.println("print Organization ...." + org);
    }

    public void printOrganizations() {

        List<Organization> organizations = getOrganizations();

        organizations.stream().forEach(org -> LOGGER.info(org.toString()));
    }

    public List<Organization> getOrganizations() {
        return organizationDao.getAllOrganizations();
    }

    public Organization getOrganization(Integer organizationId) {

        return organizationDao.getOrganization(organizationId);
    }

    public void updateOrganization(int organizationId, String companyName, int yearOfIncorporation, int postalCode, int employeeCount, String slogan) {

        Organization organization = new Organization(companyName, yearOfIncorporation, postalCode, employeeCount, slogan);

        organization.setId(organizationId);

        organizationDao.update(organization);
    }

    public void addOrganization(String companyName,int yearOfIncorporation, int postalCode, int employeeCount, String slogan) {

        Organization organization = new Organization(companyName, yearOfIncorporation, postalCode, employeeCount, slogan);

        organizationDao.create(organization);
    }
}
