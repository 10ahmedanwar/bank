package org.example.Mapper;

import org.example.DTO.TransactionDto;
import org.example.Model.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TransactionMapper {
    TransactionDto mapToDto(Transaction transaction);

}
