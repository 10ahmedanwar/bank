package org.example.Mapper;

import org.example.DTO.AccountDto;
import org.example.Model.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {
    AccountDto mapToDto(Account account);
}
