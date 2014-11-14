# coding: UTF-8

alphabets = "abcdefghijklmnopqrstuvwxyz"

while input = gets
   input.chomp!
   26.times.with_index do |i|
       output = input.tr("a-z", alphabets.split("").rotate(i).join)
       if output =~ /th(e|is|at)/
         puts output
         break
       end
   end
end
