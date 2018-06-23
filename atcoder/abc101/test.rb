def snuke(n)
  n.to_s.split('').map(&:to_i).inject(&:+)
end

1.upto(2000) do |i|
  puts "#{i}: #{snuke(i)} #{i.to_f / snuke(i)}" if i.to_s[-1] == '9'
  # puts i if (i < snuke(i))
end
