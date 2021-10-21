-- Drop table if exists `projects_steps`;
-- Drop table if exists `projects`;

-- create table `projects`(
--    `id` int primary key auto_increment,
--    `description` varchar(100) not null
-- );

-- create table `projects_steps`(
--    `id` int primary key auto_increment,
--    `description` varchar(100) not null,
--    `days_to_deadline` bigint,
--    `project_id` int,
--    foreign key (project_id) references projects(id)
-- );

-- ALTER TABLE task_groups ADD COLUMN `project_id` int;
-- ALTER TABLE task_groups ADD FOREIGN KEY (project_id) REFERENCES projects(id);