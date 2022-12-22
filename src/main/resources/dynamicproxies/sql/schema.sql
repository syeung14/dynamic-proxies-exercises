/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

CREATE TABLE A
(
    A_ID   INT         NOT NULL GENERATED ALWAYS AS IDENTITY,
    A_NAME VARCHAR(32) NOT NULL,
    A_DESC VARCHAR(32) NOT NULL
);

CREATE TABLE B
(
    B_ID   INT         NOT NULL GENERATED ALWAYS AS IDENTITY,
    A_ID   INT,
    B_NAME VARCHAR(32) NOT NULL
);