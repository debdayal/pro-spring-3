DELIMITER //
CREATE FUNCTION getFirstNameById(in_id INT)
    RETURNS VARCHAR(60)
BEGIN
    RETURN (SELECT first_name FROM contact WHERE id = in_id);
END //
DELIMITER ; 