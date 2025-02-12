package com.ishan.expensemgmt.command;



import com.ishan.expensemgmt.dtos.ResponseStatus;
import com.ishan.expensemgmt.dtos.SettleUpGroupRequestDTO;
import com.ishan.expensemgmt.dtos.SettleUpGroupResponseDTO;
import com.ishan.expensemgmt.model.Transaction;

import java.util.List;

public class SettleUpGroupCommand implements Command {

    @Override
    public boolean matches(String input){
        //cmd should look like: "Settle Up Group 1"
       List<String> words = List.of(input.split(""));
       if(words.size() != 2 && words.get(0).equals("Settle Up Group"))
           return true;
       else
           return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(""));
        Long groupId =  Long.valueOf(words.get(1));

        SettleUpGroupRequestDTO request = new SettleUpGroupRequestDTO();
        request.setGroupId(groupId);

        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();
        System.out.println(responseDTO.getResponseStatus());

        if(responseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDTO.getFailureMessage());
        } else  {
            for(Transaction transaction: responseDTO.getTransactions()){
                System.out.println(transaction.getUserFrom().getName() + " Should Pay " + transaction.getUserTo().getName() + " : " + transaction.getAmt());
            }
        }
    }


}
