/*
 * This class forms part of the Dynamic Proxies in Java Course by
 * Dr Heinz Max Kabutz from JavaSpecialists.eu and may not be distributed
 * without written consent.
 *
 * Copyright 2020, Dr Heinz Max Kabutz, All rights reserved.
 */

INSERT INTO A(A_NAME, A_DESC) VALUES (?, ?);

INSERT INTO B(A_ID, B_NAME)
SELECT A_ID, A_DESC
FROM A
ORDER BY A_ID DESC;