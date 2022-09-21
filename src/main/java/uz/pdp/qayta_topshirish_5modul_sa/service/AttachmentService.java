package uz.pdp.qayta_topshirish_5modul_sa.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Attachment;
import uz.pdp.qayta_topshirish_5modul_sa.entity.AttachmentContent;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Result;
import uz.pdp.qayta_topshirish_5modul_sa.repository.AttachmentContentRepository;
import uz.pdp.qayta_topshirish_5modul_sa.repository.AttachmentRepository;

import java.util.Iterator;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment =new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment saveAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(saveAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Muvaffaqiyatli saqlandi",true,saveAttachment.getId());



    }
}
