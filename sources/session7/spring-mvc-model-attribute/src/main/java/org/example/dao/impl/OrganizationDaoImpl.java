package org.example.dao.impl;

import org.example.dao.OrganizationDao;
import org.example.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Organization organization) {

        String sqlQuery = "INSERT INTO Organization(companyName, yearOfIncorporation, " +
                "postalCode, employeeCount, slogan) VALUES(:companyName, :yearOfIncorporation, " +
                ":postalCode, :employeeCount, :slogan)";

        SqlParameterSource params = new BeanPropertySqlParameterSource(organization);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public Organization getOrganization(int id) {

        String sqlQuery = "SELECT * FROM Organization WHERE organizationId =:id";
        SqlParameterSource params = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
    }

    @Override
    public List<Organization> getAllOrganizations() {

        String sqlQuery = "SELECT * FROM Organization";

        return namedParameterJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
    }

    @Override
    public boolean delete(Organization organization) {
        return false;
    }

    @Override
    public boolean update(Organization organization) {

        String sqlQuery = "UPDATE Organization SET CompanyName = :companyName, "
                + "yearOfIncorporation = :yearOfIncorporation, "
                + "postalCode = :postalCode, "
                + "employeeCount = :employeeCount, "
                + "slogan = :slogan "
                + "WHERE organizationId = :id";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);

        return namedParameterJdbcTemplate.update(sqlQuery, parameterSource) == 1;
    }

    @Override
    public boolean delete(int id) {

        String sqlQuery = "DELETE FROM Organization WHERE organizationId = :id";

        SqlParameterSource params = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public void cleanup() {

        String sqlQuery = "TRUNCATE TABLE Organization";

        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

    }
}
