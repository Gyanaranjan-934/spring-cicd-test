-- File: src/main/resources/db/migration/V3__update_department_title.sql
ALTER TABLE department RENAME COLUMN title TO dpt_title;