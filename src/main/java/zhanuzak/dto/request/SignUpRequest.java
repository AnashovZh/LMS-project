package zhanuzak.dto.request;

import zhanuzak.enums.Role;

public record SignUpRequest(String name, String email, String password, Role role) {
}
