package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.ChatRoom;
import com.example.demo.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatService service;

    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        List<ChatRoom> chatRooms = chatRoomRepository.findAllRoom();
        log.info("chatRooms{}", chatRooms);
        //chatRooms.stream().forEach(room -> room.setUserCount(chatRoomRepository.getUserCount(room.getRoomId())));
        return chatRooms;
    }

    @GetMapping("/room")
    @ResponseBody
    public ChatRoom roomInfo(@RequestParam("roomId") String roomId) { //ROOMID 로 채팅방 조회

        return chatRoomRepository.findRoomById(roomId);
    }

//    @GetMapping("/room")
//    @ResponseBody
//    public ChatRoom FindroomId(@RequestParam String name) { //ROOMID 로 채팅방 조회
//
//        return chatRoomRepository.findRoomByName(name);
//    }


//    @PostMapping
//    public ChatRoom createRoom(@RequestParam String name){
//
//        return service.createRoom(name);
//    }
//
//    @GetMapping
//    public List<ChatRoom> findAllRooms(){
//        return service.findAllRoom();
//    }
}