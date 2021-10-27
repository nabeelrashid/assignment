-- -----------------------------------------------------
-- `TECH VISTA`.`DEPARTMENTS`
-- -----------------------------------------------------

create schema techvista;
CREATE TABLE IF NOT EXISTS `techvista`.`departments` (
    `department_id` INT(4) NOT NULL,
    `department_name` VARCHAR(30) NULL,
    `manager_id` INT(6) NULL,
    PRIMARY KEY (`department_id`));
insert INTO `techvista`.`departments` (`department_id`, `department_name`) VALUES ('1', 'HR');
insert INTO `techvista`.`departments` (`department_id`, `department_name`) VALUES ('2', 'Finance');
insert INTO `techvista`.`departments` (`department_id`, `department_name`) VALUES ('3', 'Sales & Marketing');
