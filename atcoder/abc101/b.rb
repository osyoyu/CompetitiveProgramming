I = gets.chomp.to_i
R = I.to_s.split('').map(&:to_i).inject

if I % R == 0
  puts "Yes"
else
  puts "No"
end
